class TimeMap {
    Map<String, TreeMap<Integer, String>> map; 
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap timeMap = map.getOrDefault(key, new TreeMap<>());
        timeMap.put(timestamp, value);
        map.put(key, timeMap);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap timeMap = map.get(key);
        Object nextKey = timeMap.floorKey(timestamp);
        if(nextKey == null) return "";
        return (String) timeMap.get((int) nextKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */