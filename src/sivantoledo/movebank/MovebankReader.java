package sivantoledo.movebank;

import java.io.IOException;
import java.io.Reader;

public class MovebankReader extends Reader {
  
  public static class LicenseException extends Error {
    /**
     * 
     */
    private static final long serialVersionUID = -7981678300885288429L;

    public LicenseException(String message) { super(message); }
  }
  
  private Reader source;
  
  public MovebankReader(Reader r) {
    this.source = r;
  }
  
  @Override public boolean markSupported() { return false; }
  
  private char[] buffer = new char[ 16384 ];
  private int start = 0;
  private int l     = 0; // character in the buffer
  
  private int hasLicense = 0; // don't know yet
  private StringBuffer prefix = new StringBuffer();

  @Override
  public boolean ready() throws IOException {
    if (l > 0) return true;
    return source.ready();
  }
  
  @Override
  public int read(char[] cbuf, int off, int len) throws IOException {
    int n = -1;
    
    if (l==0) {
      l = source.read(buffer,0,buffer.length);
      if (l==-1) return -1;
      if (hasLicense==0) {
        prefix.append(buffer, 0, l);
        if (prefix.length() > 200) {
          if (prefix.toString().startsWith("The requested download may contain copyrighted material.")) {
            while (true) {
              l = source.read(buffer,0,buffer.length);
              if (l==-1) {
                throw new LicenseException(prefix.toString());
              }
              prefix.append(buffer, 0, l);
            }
          }
          prefix = null; // release memory
          hasLicense = 1;
        }
      }
    }
        
    /* if we got here, l > 0 */
    
    if (len > l) n = l;
    else         n = len;
    for (int i=0; i<n; i++) {
      cbuf[off+i] = buffer[start+i];
    }
    l = l - n;
    return n;
  }

  @Override
  public void close() throws IOException {
    source.close();
  }
}
