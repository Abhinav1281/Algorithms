package Search;
import java.util.*;



public class BinarySearch 
{
    
    public static int BSearch(List<Integer> arr,int n,int l,int r)
    {
        if(r>=l)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid)==n)
                return mid;
            else if(arr.get(mid)<n)
                return BSearch(arr, n, l, mid-1);
            else
                return BSearch(arr, n, mid+1, r);
        }
        return -1;
    }
}
