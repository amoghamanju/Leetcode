class TimeMap {
    private Map<String,List<Integer>> timemap;
    private Map<String,List<String>> valuemap;
    public TimeMap() {
        timemap=new HashMap<>();
        valuemap=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timemap.putIfAbsent(key,new ArrayList<>());
        valuemap.putIfAbsent(key,new ArrayList<>());
        
        timemap.get(key).add(timestamp);
        valuemap.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!timemap.containsKey(key)) return "";
        List<Integer> times=timemap.get(key);
        List<String> values=valuemap.get(key);
        String res="";
        int left=0,right=times.size()-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(times.get(mid)<=timestamp)
            {
                res=values.get(mid);
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */