package ru.academit.babynina;

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

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
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
        double resultRangeFrom;
        double resultRangeTo;
        double rangeFrom = range.getFrom();
        double rangeTo = range.getTo();

        if (this.from == rangeFrom) {
            resultRangeFrom = this.from;
        } else if (this.from < rangeFrom) {
            if (this.isInside(rangeFrom)) {
                resultRangeFrom = rangeFrom;
            } else {
                return null;
            }
        } else {
            if (range.isInside(this.from)) {
                resultRangeFrom = this.from;
            } else {
                return null;
            }
        }

        if (this.to == rangeTo) {
            resultRangeTo = this.to;
        } else if (this.to < rangeTo) {
            resultRangeTo = this.to;
        } else {
            resultRangeTo = range.to;
        }

        if (resultRangeFrom == resultRangeTo) {
            return null;
        } else {
            return new Range(resultRangeFrom, resultRangeTo);
        }
    }

    public Range[] getUnion(Range range) {
        double firstResultRangeFrom;
        double firstResultRangeTo;
        double secondResultRangeFrom = 0;
        double secondResultRangeTo = 0;
        double rangeFrom = range.getFrom();
        double rangeTo = range.getTo();

        if (this.from == rangeFrom) {
            firstResultRangeFrom = this.from;
        } else if (this.from < rangeFrom) {
            if (this.isInside(rangeFrom)) {
                firstResultRangeFrom = this.from;
            } else {
                firstResultRangeFrom = this.from;
                secondResultRangeFrom = rangeFrom;
            }
        } else {
            if (range.isInside(this.from)) {
                firstResultRangeFrom = rangeFrom;
            } else {
                firstResultRangeFrom = rangeFrom;
                secondResultRangeFrom = this.from;
            }
        }

        if (this.to == rangeTo) {
            firstResultRangeTo = this.to;
        } else if (this.to < rangeTo) {
            if (range.isInside(this.to)) {
                firstResultRangeTo = rangeTo;
            } else {
                firstResultRangeTo = this.to;
                secondResultRangeTo = rangeTo;
            }
        } else {
            firstResultRangeTo = this.to;
        }

        Range[] resultRanges;
        Range firstResultRange = new Range(firstResultRangeFrom, firstResultRangeTo);

        if (secondResultRangeFrom == 0 && secondResultRangeTo == 0) {
            resultRanges = new Range[1];
            resultRanges[0] = firstResultRange;
        } else {
            Range secondResultRange = new Range(secondResultRangeFrom, secondResultRangeTo);
            resultRanges = new Range[2];
            resultRanges[0] = firstResultRange;
            resultRanges[1] = secondResultRange;
        }
        return resultRanges;
    }

    public Range[] getDifference(Range range) {
        double firstResultRangeFrom;
        double firstResultRangeTo;
        double secondResultRangeFrom = 0;
        double secondResultRangeTo = 0;
        double rangeFrom = range.getFrom();
        double rangeTo = range.getTo();

        if (this.isInside(rangeFrom)) {
            if (this.to == rangeFrom) {
                return null;
            } else {
                firstResultRangeFrom = this.from;

                if (this.isInside(rangeTo)) {
                    firstResultRangeTo = rangeFrom;
                    secondResultRangeFrom = rangeTo;
                    secondResultRangeTo = this.to;
                } else {
                    firstResultRangeTo = rangeFrom;
                }
            }
        } else {
            if (this.isInside(rangeTo)) {
                if (rangeTo == this.from) {
                    return null;
                } else {
                    firstResultRangeFrom = rangeTo;
                    firstResultRangeTo = this.to;
                }
            } else {
                return null;
            }
        }

        Range[] resultRanges;
        Range firstResultRange = new Range(firstResultRangeFrom, firstResultRangeTo);

        if (secondResultRangeFrom == 0 && secondResultRangeTo == 0) {
            resultRanges = new Range[1];
            resultRanges[0] = firstResultRange;
        } else {
            Range secondResultRange = new Range(secondResultRangeFrom, secondResultRangeTo);
            resultRanges = new Range[2];
            resultRanges[0] = firstResultRange;
            resultRanges[1] = secondResultRange;
        }
        return resultRanges;
    }
}