
class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<Integer>((a, b) -> b - a);
        right = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (left.size() == 0 || num < left.peek())
            left.add(num);
        else
            right.add(num);

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() == right.size())
            return (left.peek() + right.peek()) / 2.0;

        return left.size() > right.size() ? left.peek() : right.peek();
    }
}
