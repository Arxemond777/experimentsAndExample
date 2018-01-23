package shenandoah_first_acquaintance;

import java.math.BigDecimal;

// -Xms115G -Xmx115G -XX:+UseShenandoahGC -verbose:gc
// -Xms115G -Xmx115G -XX:+UseG1GC -verbose:gc
// -Xms115G -Xmx115G -XX:+UseParNewGC -verbose:gc

public class e1 {
    public static void main(String[] args) {
        BigDecimal i;
        while (true)
                if (a().equals(BigDecimal.ONE))
                    i = a();
        else i = BigDecimal.TEN;
    }
    public static BigDecimal a() {
        BigDecimal bigDecimal = null;
        for (long i = 0; i < 100000000L; i++)

            bigDecimal = new BigDecimal(Math.random());

        return bigDecimal;
    }
}
