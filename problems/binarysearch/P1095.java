package binarysearch;

public class P1095 {

    interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = getPeak(mountainArr);

        int leftPartAnswer = findValueInNonDecreasedPart(mountainArr, peakIndex, target);
        if (leftPartAnswer == -1) {
            return findValueInNonIncreasedPart(mountainArr, peakIndex, target);
        }
        return leftPartAnswer;
    }

    private int findValueInNonDecreasedPart(MountainArray mountainArr, int border, int target) {
        int l = 0;
        int r = border;
        int mid;
        while (r > l) {
            mid = (r + l) / 2;
            if (mountainArr.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l < mountainArr.length() && mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }


    private int findValueInNonIncreasedPart(MountainArray mountainArr, int border, int target) {
        int l = border + 1;
        int r = mountainArr.length();
        int mid;
        while (r > l) {
            mid = (r + l) / 2;
            if (mountainArr.get(mid) <= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l < mountainArr.length() && mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }

    private int getPeak(MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length();
        int mid;
        while (r > l) {
            mid = (l + r) / 2;
            int midValue = mountainArr.get(mid);
            if (mid == mountainArr.length()) {
                r = mid - 1;
                continue;
            }
            if (mid == 0 || mountainArr.get(mid - 1) < midValue && mountainArr.get(mid + 1) > midValue) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
