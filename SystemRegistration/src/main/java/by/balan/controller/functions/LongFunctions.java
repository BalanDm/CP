package by.balan.controller.functions;

/**
 * Created by Ultrabook on 15.05.2015.
 */
public class LongFunctions {
    public boolean checkStringToLong(String str)
    {   try{
        Long.parseLong(str);
    }
    catch (Exception e){
        return false;}
        return true;
    }
}
