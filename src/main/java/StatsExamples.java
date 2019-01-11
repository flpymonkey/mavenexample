import org.apache.commons.math3.distribution.NormalDistribution;

public class StatsExamples {
    public static void main(String[] args){
        /* initialize with default m=0 and s=1 */
        NormalDistribution dist = new NormalDistribution();
        double lowerBound = dist.getSupportLowerBound(); // 0.0
        double upperBound = dist.getSupportUpperBound(); // Infinity
        double mean = dist.getNumericalMean(); // 1.649
        double variance = dist.getNumericalVariance(); // 4.671
        double density = dist.density(1.0); // 0.3989
        double cumulativeProbability = dist.cumulativeProbability(1.0); // 0.5
        double sample = dist.sample(); // 0.428
        double[] samples = dist.sample(3); // {0.109, 5.284, 2.032}

        System.out.println(samples);
    }
}
