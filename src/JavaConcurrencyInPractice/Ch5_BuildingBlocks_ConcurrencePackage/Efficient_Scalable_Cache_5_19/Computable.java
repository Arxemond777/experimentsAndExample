package JavaConcurrencyInPractice.Ch5_BuildingBlocks_ConcurrencePackage.Efficient_Scalable_Cache_5_19;

public interface Computable<A, V> {
    V compute (A arg) throws InterruptedException;
}
