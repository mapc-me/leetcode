package slidingwindow;

public class P1358 {
    public int numberOfSubstrings(String s) {
        int[] track = new int[3]; // 0 - 'a', 1 - 'b', 2 - 'c'

        int lastOne = 0;
        int ans = 0;

        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;

            while (hasTriple(track)) {
                lastOne += 1;
                track[s.charAt(l) - 'a']--;
                l++;
            }
            ans += lastOne;
        }

        return ans;

    }

    public boolean hasTriple(int[] track) {
        return track[0] > 0 && track[1] > 0 && track[2] > 0;
    }
}
