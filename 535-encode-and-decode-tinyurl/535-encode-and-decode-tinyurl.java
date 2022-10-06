public class Codec {
    int counter = 0;
    Map<Integer, String> db = new HashMap<>();
    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        db.put(counter, longUrl);
        int n = counter;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(map[n%62]);
            n /= 62;
        }
        counter++;
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int id = 0; 
        for (int i = 0; i < shortUrl.length(); i++)
        {
            if ('a' <= shortUrl.charAt(i) &&
                       shortUrl.charAt(i) <= 'z')
            id = id * 62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) &&
                       shortUrl.charAt(i) <= 'Z')
            id = id * 62 + shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) &&
                       shortUrl.charAt(i) <= '9')
            id = id * 62 + shortUrl.charAt(i) - '0' + 52;
        }
        return db.getOrDefault(id, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));