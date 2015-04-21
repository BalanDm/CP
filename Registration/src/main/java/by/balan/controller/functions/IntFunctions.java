package by.balan.controller.functions;

/**
 * Created by Ultrabook on 21.04.2015.
 */
public class IntFunctions {
    public boolean checkStringToInt(String str)
    {   try{
        Integer.parseInt(str);
    }
    catch (Exception e){
        return false;}
        return true;
    }
}
