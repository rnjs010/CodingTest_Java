class Solution {
    static double curHd, curMd, curSd;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int ans = 0;
        int start = h1*3600 + m1*60 + s1;
        int end = h2*3600 + m2*60 + s2;
        
        calDegree(h1, m1, s1);
        while(start < end) {
            start++;
            ans += nextD();
        }
        
        calDegree(h1, m1, s1);
        if (Double.compare(curHd, curMd) == 0 || Double.compare(curMd, curSd) == 0) ans++;
        calDegree(h2, m2, s2);
        if (Double.compare(curHd, curMd) == 0 || Double.compare(curMd, curSd) == 0) ans++;
        
        return ans;
    }
    
    public void calDegree(int h, int m, int s) {
        curHd = (h % 12)*30 + m*(0.5) + s*((double) 1/120);
        curMd = (m*6) + (s*0.1);
        curSd = s*6;
    }
    
    public int nextD() {
        int cnt = 0;
        double nextHd = curHd + ((double) 1/120);
        double nextMd = curMd + 0.1;
        double nextSd = curSd + 6;
        
        if (Double.compare(curHd, curSd) > 0 && Double.compare(nextHd, nextSd) <= 0) cnt++;
        if (Double.compare(curMd, curSd) > 0 && Double.compare(nextMd, nextSd) <= 0) cnt++;
        if ((Double.compare(curHd, curMd) > 0 && Double.compare(curHd, curSd) > 0 && Double.compare(nextHd, nextMd) <= 0) && Double.compare(nextHd, nextSd) <= 0) cnt--;
        
        curHd = nextHd % 360;
        curMd = nextMd % 360;
        curSd = nextSd % 360;
        return cnt;
    }
}