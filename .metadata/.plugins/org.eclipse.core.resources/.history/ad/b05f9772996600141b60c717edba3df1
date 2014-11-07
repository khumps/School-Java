import java.util.ArrayList;

public class Statistics {

	public static double[] copyData(double[] data) {
		double[] copy = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}
		return copy;
	}

	public static double[] copyData(double[] data, int firstIndex, int lastIndex) {
		double[] dest = new double[Math.abs(lastIndex - firstIndex) + 1];
		int j = 0;
		for (int i = firstIndex; i < lastIndex + 1; i++) {
			dest[j] = data[i];
			j++;
		}
		return dest;
	}
<<<<<<< HEAD
	
	public static double[] heapSort(double[] data)
	{
		double[] copy = copyData(data);
		for(int i = 0, j = copy.length - 1; i < j; i++, j--)
		{
			copy[i] = min(copyData(copy,i,j));
			copy[j] = max(copyData(copy,i,j));
		}
		
		return copy;
	}
=======
>>>>>>> origin/master

	public static double sum(double[] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public static double[] sortData(double[] data) {
		double[] sorted = copyData(data);
		for (int inner = 0; inner < sorted.length; inner++) {
			for (int outer = inner + 1; outer < sorted.length; outer++) {
				if (sorted[inner] > sorted[outer]) {
					double temp = sorted[inner];
					sorted[inner] = sorted[outer];
					sorted[outer] = temp;
				}
			}

		}
		return sorted;
	}

	public static double mean(double[] data) {
		double mean = 0;
		for (int i = 0; i < data.length; i++) {
			mean += data[i];
		}
		return mean /= data.length;
	}

	public static double median(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		double median = 0;
		double[] copy = sortData(data);
		if (copy.length % 2 == 0) {
			int findMedian = (copy.length / 2) - 1;
			int minMedian = (0 + findMedian);
			int maxMedian = (copy.length - findMedian) - 1;
			median = (copy[minMedian] + copy[maxMedian]) / 2;
			// System.out.println(median);
			return median;
		}
		int findMedian = (copy.length / 2);
		// System.out.println(findMedian);
		return copy[findMedian];

	}

	public static String arrayToString(double[] a) {
		String s = "[";
		for (int i = 0; i < a.length; i++)
			s += a[i] + ", ";
		s += "]";
		return s;
	}

	public static double min(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		double min = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] < min)
				min = data[i];
		}
		return min;
	}

	/*
	 * Returns the Maximum data value for data[]
	 */
	public static double max(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		double max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max)
				max = data[i];
		}
		return max;
	}

	/*
	 * Returns the range of the data(Max - Min)
	 */
	public static double range(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		double[] dataCopy = copyData(data);
		return max(dataCopy) - min(dataCopy);
	}

	/*
	 * Returns the Lower Quartile for data[]
	 */

	public static double lowerQuartile(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		int medianIndex = 0;
		double[] copy = copyData(data);
		double median = median(copy);
		for (int i = 0; copy[i] < median; i++) {
			medianIndex = i;
		}
		double upperQ = median(copyData(copy, 0, medianIndex));
		return upperQ;

	}

	/*
	 * Returns the Upper Quartile for data[]
	 */
	public static double upperQuartile(double[] data) {
		if (data.length == 0)
			return Double.NaN;
		int medianIndex = 0;
		double[] copy = copyData(data);
		double median = median(copy);
		for (int i = copy.length - 1; copy[i] > median; i--) {
			medianIndex = i;
		}
		double upperQ = median(copyData(copy, medianIndex, copy.length - 1));
		return upperQ;

	}

	public static double interquartileRange(double[] data) {
		return upperQuartile(data) - lowerQuartile(data);
	}

	/*
	 * Returns the mode(if any) for data[]
	 */
	public static ArrayList<Double> mode(double[] data) {
		double[] copy = sortData(data);
		ArrayList<ArrayList<Double>> values = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> same = new ArrayList<Double>();
		ArrayList<Double> mode = new ArrayList<Double>();
		int i;
		int j;
		int noMode = 0;
		for (i = 0; i < copy.length;) {
			same.add(copy[i]);
			for (j = i + 1; j < copy.length && copy[i] == copy[j]; j++)
				same.add(copy[j]);
			values.add(new ArrayList<Double>(same));
			same.clear();
			i = j;
		}
		int freq = 0;
		for (i = 0; i < values.size(); i++) {
			if (values.get(i).size() > freq) {
				mode.clear();
				mode.add(values.get(i).get(0));
				freq = values.get(i).size();
			} else if (values.get(i).size() == freq) {
				mode.add(values.get(i).get(0));
				noMode++;
			}

		}
		System.out.println(freq);
		if (noMode > values.size() / 2)
			return new ArrayList<Double>();

		return mode;
	}

	/*
	 * Returns the Standard Deviation for data[]
	 */
	public static double standardDeviation(double[] data) {
		double[] squared = new double[data.length];
		double mean = mean(data);
		for (int i = 0; i < squared.length; i++)
			squared[i] = (data[i] - mean) * (data[i] - mean);
		double devMean = sum(squared) / (squared.length - 1);
		return Math.sqrt(devMean);

	}

	/*
	 * Returns the Z-Score of the data point at data[index]
	 */
	public static double zScore(double[] data, int index) {
		return (data[index] - mean(data)) / standardDeviation(data);
	}
	
	public static ArrayList<Double> outliers(double[] data)
	{
		if(data.length < 6)
			return new ArrayList<Double>();
		ArrayList<Double> outliers = new ArrayList<Double>();
		double isOutlier = 1.5 * interquartileRange(data);
		double lOutliers = lowerQuartile(data) - isOutlier;
		double uOutliers = upperQuartile(data) + isOutlier;
		for(int i = 0; i < data.length; i++)
			
		{
<<<<<<< HEAD
				if(data[i] < lOutliers || data[i] > uOutliers)
					outliers.add(data[i]);
=======
			if(Math.abs(lowerQuartile(data) - data[i]) < Math.abs(upperQuartile(data) - data[i]))
			{
				if(data[i] < lOutliers)
					outliers.add(data[i]);
				
			if(Math.abs(lowerQuartile(data) - data[i]) > Math.abs(upperQuartile(data) - data[i]))
			{
				if(data[i] > uOutliers)
					outliers.add(data[i]);
			}
			}
>>>>>>> origin/master
		}
		
		return outliers;
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		double[] test = new double[10000];
				for(int i = 0; i < test.length; i++)
				{
					test[i] = Math.random() * 100;
				}
		long start = System.nanoTime();
		ArrayList<Double> copy2 = outliers(test);
		long stop = System.nanoTime();
		System.out.println(stop - start);
		
=======
		double[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,250 };
		System.out.println(arrayToString(test));
		double[] copy = copyData(test);
		System.out.println(outliers(test));
>>>>>>> origin/master

	}
}
