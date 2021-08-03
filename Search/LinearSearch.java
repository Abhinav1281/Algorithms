package Search;
import java.util.*;

public class LinearSearch
{

    public static int LSearch(List<Integer> arr,int n)
    {
        for(int i=0;i<arr.size();i++)
            if(arr.get(i)==n)
                return i;
        return -1;
    }
}