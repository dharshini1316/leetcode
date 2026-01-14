import java.util.*;

class Solution {
    static class Event {
        double y, x1, x2;
        int type;
        Event(double y, double x1, double x2, int type) {
            this.y = y; this.x1 = x1; this.x2 = x2; this.type = type;
        }
    }

    static class SegTree {
        int n;
        double[] len, cover;
        double[] xs;

        SegTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            len = new double[4 * n];
            cover = new double[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql > r || qr < l) return;
            if (ql <= l && r <= qr) {
                cover[node] += val;
            } else {
                int m = (l + r) / 2;
                update(node * 2, l, m, ql, qr, val);
                update(node * 2 + 1, m + 1, r, ql, qr, val);
            }
            if (cover[node] > 0) {
                len[node] = xs[r + 1] - xs[l];
            } else if (l == r) {
                len[node] = 0;
            } else {
                len[node] = len[node * 2] + len[node * 2 + 1];
            }
        }

        double query() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        Set<Double> xset = new HashSet<>();

        for (int[] s : squares) {
            double x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, 1));
            events.add(new Event(y + l, x, x + l, -1));
            xset.add(x);
            xset.add(x + l);
        }

        double[] xs = xset.stream().sorted().mapToDouble(Double::doubleValue).toArray();
        Map<Double, Integer> xi = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xi.put(xs[i], i);

        events.sort(Comparator.comparingDouble(e -> e.y));
        SegTree st = new SegTree(xs);

        List<double[]> slabs = new ArrayList<>();
        double prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            double curY = e.y;
            double width = st.query();
            if (curY > prevY && width > 0) {
                double slabArea = width * (curY - prevY);
                slabs.add(new double[]{prevY, curY, slabArea});
                area += slabArea;
            }
            int l = xi.get(e.x1);
            int r = xi.get(e.x2) - 1;
            st.update(1, 0, st.n - 1, l, r, e.type);
            prevY = curY;
        }

        double half = area / 2.0;
        double acc = 0;

        for (double[] s : slabs) {
            if (acc + s[2] >= half) {
                double dy = (half - acc) / (s[2] / (s[1] - s[0]));
                return s[0] + dy;
            }
            acc += s[2];
        }
        return slabs.get(slabs.size() - 1)[1];
    }
}