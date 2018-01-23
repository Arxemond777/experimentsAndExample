package concurrency.five_scientists;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithStaticReferenceForTheFiveScientists {
    void exec() throws InterruptedException {

        List<Thread> threadList = Stream.of(TheFiveScientists.EScientist.values())
                .map(s -> { //TODO
                    CreateThreadImpl cti = new CreateThreadImpl();

                    CreateThread createThread = CreateThreadImpl::getScientistImpl;
                    return createThread.getScientist(cti, s);
                })
                .collect(Collectors.toList());

        while (true) {
            System.out.printf(
                    "1 | %d" + System.lineSeparator() +
                            "2 | %d" + System.lineSeparator() +
                            "3 | %d" + System.lineSeparator() +
                            "4 | %d" + System.lineSeparator() +
                            "5 | %d" + System.lineSeparator(),
                    TheFiveScientists.EScientist.FIRST.getScientist().getCurrentEat(),
                    TheFiveScientists.EScientist.SECOND.getScientist().getCurrentEat(),
                    TheFiveScientists.EScientist.THIRD.getScientist().getCurrentEat(),
                    TheFiveScientists.EScientist.FORTH.getScientist().getCurrentEat(),
                    TheFiveScientists.EScientist.FIFTH.getScientist().getCurrentEat()
            );
            TimeUnit.SECONDS.sleep(3);
        }
    }
}

@FunctionalInterface
interface CreateThread {
    Thread getScientist(CreateThreadImpl createThread, TheFiveScientists.EScientist eScientist);
}

class CreateThreadImpl {
    public Thread getScientistImpl(TheFiveScientists.EScientist eScientist) {
        return new Thread(eScientist.getScientist(), eScientist.getName());
    }
}
