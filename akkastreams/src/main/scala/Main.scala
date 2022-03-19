import java.lang.Thread.currentThread;
import java.time.LocalDateTime;
import scala.collection.mutable;
import scala.concurrent.duration.MINUTES;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

object Application {
  def main(args: Array[String]): Unit = {
    /*
    val minhaThread: Runnable = () => {
      while (true) {
        println(s"exxecutando ${LocalDateTime.now} na thread ${currentThread().getName}");
        sleep(1000L);
      }
    }
    val thread = new Thread(minhaThread);
    thread.run();*/

    sharedAtomicVar;
  }

  def singleThreads(): Unit = {
    println(s"executando (inicio do processamento) ${LocalDateTime.now}");
    @volatile val stack = mutable.Stack[Int]();
    stack.pushAll(List.range(1, 9000000));

    while (stack.nonEmpty) {
      stack.pop();
    }
    println(s"executando (termino do processamento) ${LocalDateTime.now}");
  }

  def multiThread(): Unit = {
    println(s"executando (inicio do processamento) ${LocalDateTime.now}")

    @volatile var stack = mutable.Stack[Int]();
    stack.pushAll(List.range(1, 9990000));

    val implementacao: Runnable = () => {
      if (stack.nonEmpty) stack.pop();
    }

    val servicoExecucao = Executors.newCachedThreadPool;
    servicoExecucao.execute(implementacao);
    servicoExecucao.execute(implementacao);
    servicoExecucao.execute(implementacao);
    servicoExecucao.execute(implementacao);
    servicoExecucao.execute(implementacao);

    servicoExecucao.shutdown();
    servicoExecucao.awaitTermination(1, MINUTES);

    println(s"executando (termino do processamento) ${LocalDateTime.now}")
  }

  private def sharedMemory = {
    var contador: Int = 0

    val somador = () => {
      contador += 1
      contador
    }

    val redutor = () => {
      contador -= 1
      contador
    }

    val operador = (operacao: () => Int, identifcadorOperacao: String) => {
      for (i <- List.range(1, 120)) println(f"executando a operacao" +
        f" $identifcadorOperacao - valor do contador ${operacao()}")
    }

    val servicoExecucao = Executors.newCachedThreadPool

    servicoExecucao.execute(() => {
      operador(somador, "soma")
    })
    servicoExecucao.execute(() => {
      operador(redutor, "subtração")
    })

    servicoExecucao.shutdown()

    servicoExecucao.awaitTermination(1, MINUTES)

  }

  private def sharedAtomicVar = {
    var contador: AtomicInteger = new AtomicInteger(0);

    val somador = () => {
      contador.addAndGet(1)
    }

    val redutor = () => {
      contador.addAndGet(-1)
    }

    val operador = (operacao: () => Int, identifcadorOperacao: String) => {
      for (i <- List.range(1, 120)) println(f"executando a operacao" +
        f" $identifcadorOperacao - valor do contador ${operacao()}")
    }

    val servicoExecucao = Executors.newCachedThreadPool

    servicoExecucao.execute(() => {
      operador(somador, "soma")
    })
    servicoExecucao.execute(() => {
      operador(redutor, "subtração")
    })

    servicoExecucao.shutdown()

    servicoExecucao.awaitTermination(1, MINUTES)

  } 
}
