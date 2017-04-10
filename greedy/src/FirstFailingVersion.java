
public class FirstFailingVersion {

    private static long fbvRecurse(long high, IsFailingVersion isBadVersion, long low){
        long version = (high+low)/2;
        if(high > low){
            if (isBadVersion.isFailingVersion(version)){
                if(!isBadVersion.isFailingVersion(version-1)) return version;
                return fbvRecurse(version, isBadVersion, low);
            } else {
                if(isBadVersion.isFailingVersion(version+1)) return version+1;
                return fbvRecurse(high, isBadVersion, version);
            }
        }
        return -1;

    }

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
       return fbvRecurse(n, isBadVersion, 0);
    }
}
