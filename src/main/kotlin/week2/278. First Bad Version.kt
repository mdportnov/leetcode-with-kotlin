//package week2
//
//class Solution : VersionControl() {
//    override fun firstBadVersion(n: Int): Int {
//        var low = 0
//        var high = n
//
//        while (low < high) {
//            var mid = low + (high - low) / 2
//            if (isBadVersion(mid) == false)
//                low = mid + 1
//            else high = mid - 1
//        }
//        return low
//    }
//}