
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import java.io.File;
import java.io.IOException;

/**
 * Created by ArnoldG3 on 4/28/2017.
 */

public class ValidatorMain {

    public static void main( String[] args ) throws IOException, ProcessingException
    {
        // Created and instance to get the class loder
        ValidatorMain obj = new ValidatorMain();

        // Getting the class loader of ValidatorMain to be able to access the resources
        ClassLoader classLoader = obj.getClass().getClassLoader();

        File schemaFile = new File(classLoader.getResource("schema.json").getFile());
        File jsonFile = new File(classLoader.getResource("data.json").getFile());

        // This will produce a report. See ValidationUtils for the Iterator code I added
        //File jsonFile = new File(classLoader.getResource("invalid_data.json").getFile());

        if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
            System.out.println("Valid!");
        }else{
            System.out.println("NOT valid!");
        }

    }
}
