package ru.academit.babynina.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (Math.max(from, range.from) >= Math.min(to, range.to)) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (Math.max(from, range.from) > Math.min(to, range.to)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.min(to, range.to)), new Range(Math.max(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (to == range.to & from == range.from) {
            return new Range[]{};
        }

        if (Math.max(from, range.from) >= Math.min(to, range.to)) {
            return new Range[]{new Range(from, to)};
        }

        if (range.from < to & range.to < to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(from, range.from)), new Range(Math.min(to, range.to), Math.max(to, range.to))};
        }

        return new Range[]{new Range(from, range.from)};
    }

    @Override
    public String toString() {
        return " от " + from + " до " + to;
    }
}