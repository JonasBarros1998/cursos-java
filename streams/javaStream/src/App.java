import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * Iniciando uma stream vazia
         */
        Stream<String> streamEmpty = Stream.empty();


        /*
         * Eu posso criar uma stream apartir da qualquer tipo de coleção
         * (Collection, List, Set)
         */
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("a");
        arrList.add("b");
        arrList.stream();



        /**
         * Posso iniciar uma stream apartir de uma sequencia de elementos
         */
        Stream<String> arrStream = Stream.of("a", "b", "c", "d");


        /**
         * Criando uma nova stream
         */
        Stream<String> streambd = Stream.<String>builder()
            .add("a")
            .add("b")
            .add("c").build();
    
        
        /**
         * Geração de novos elementos
         * Aqui posso criar quantos valores que eu quiser
         */
        Stream<String> streamGenerate = Stream.generate(() -> "elemento").limit(10);
        Stream<Integer> streamPri = Stream.generate(() -> 12).limit(10);

        
        /**
         * Convertendo um tipo stream para um tipo List, utilizando 
         * os metodos do Collectors
         */
        List<String> listStr = 
            Stream.of("a", "b", "c", "b")
                .filter(element -> {
                    //System.out.println(element.toString());
                    return element.contains("b");
                }).collect(Collectors.toList());
        
        
        
        List<Product> productsArr = Arrays.asList(
            new Product(90, "morango"),
            new Product(14, "jabuticaba"),
            new Product(23, "morango"),
            new Product(67, "ameixa"),
            new Product(100, "amora"));
        /*
         * Convertendo um stream para um Collection
        */
        productsArr.stream().collect(Collectors.toList());


        /**
         * Utilizando o Join para juntar os nomes dos produtos
         */
        productsArr.stream().map(Product::getName).collect(Collectors.joining());


        /**
         * Valor médio dos produtos da classe Product 
         */
        productsArr
            .stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        
        /**
         * Soma de todos os elementos
         */
        var sumPrice = productsArr
                .stream()
                .collect(Collectors.summingDouble(Product::getPrice));
        

        /**
         * Agrupa todos os elementos a partir do nome
         */
    
        Map<String, List<Product>> groupingByName = productsArr
            .stream()
            .collect(Collectors.groupingBy(Product::getName));
        

        /**
         * Agrupa todos os elementos e conta a quantidade de elementos repetidos
         */

        Set<Entry<String, List<Product>>> groupingAndCount = productsArr
            .stream()
            .collect(Collectors.groupingBy(Product::getName)).entrySet();
    
        for (Entry<String, List<Product>> item : groupingAndCount) {}


        /**
         * agrupando produtos a partir de 30 reais
         */
        Map<Boolean, List<Product>> partitioningBy = productsArr.stream()
            .collect(Collectors.partitioningBy(element -> element.getPrice() > 30));

    }
}
