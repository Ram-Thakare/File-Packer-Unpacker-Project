package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

public class PackerGUI
{
    private String PackName;
    private String DirName;

    public MarvellousPackerGUI(String A, String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public boolean PackingActivity()
    {
        try
        {
            
            int i = 0, j = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);

            // Check the existance of Directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {

                File PackObj = new File(PackName);

                // Create a packed file
                boolean bRet = PackObj.createNewFile();

                if(bRet == false)
                {
                    return false;
                }

                // Retive all files from directory
                File Arr[] = fobj.listFiles();

                // Packed file object
                FileOutputStream foobj = new FileOutputStream(PackObj);
                
                // Buffer for read and write activity
                byte Buffer[] = new byte[1024];

                String Header = null;

                // Directory traversal
                for(i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName() + " " + Arr[i].length();
                
                    // Loop to form 100 bytes header
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }
                    
                    // Write header into pacekd file
                    foobj.write(Header.getBytes());

                    // Open file from directoy for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    // Write contents of file into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        
                    }

                    fiobj.close();
                    iCountFile++;
                }   

                return true;
            }
            else
            {
                return false;
            }
        } // End of try
        catch(Exception eobj)
        {}

        return false;
    } // End of PackingActivity function
    
} // End of MarvellousPacker class
