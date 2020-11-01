package comp1110.exam;

/**
 * COMP1110 Exam, Question 5
 */
public class Q5StringHash {
    /**
     * Return a hash of the given string as an integer in the range 0 ... buckets - 1.
     *
     * @param value   The string to be hashed
     * @param buckets The number of buckets into which the hash should be made (defining its range)
     * @return An integer hash of value in the range 0 ... buckets - 1.
     */
    public static int hash(String value, int buckets) {
        // FIXME complete this method, without using Java's built-in hashCode() method
        /* 除留取余法 */
//        return value.length() % buckets;
        /* 平方取中法 */
//        return (int) (Math.pow((int)value.charAt(0), 2) +
//                (int)value.charAt(value.length()-1))
//                % buckets;
        /* 二次方不行就上三次方 */
        return (int) (Math.pow((int)value.charAt(0), 3) +
                (Math.pow((int)value.charAt(value.length()-1), 2)) +
                (int)value.charAt(value.length()/2))
                % buckets;
    }
}
