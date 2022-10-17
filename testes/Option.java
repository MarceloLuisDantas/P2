import java.util.Optional;

public class Option {
    public static void main(String[] args) {
        Optional<Cat> gato = getCat("Ymir");
        Cat ymir = gato.orElseGet(() -> newCat("Ymir"));
        System.out.println(ymir.getName());
    }
    public static Cat newCat(String nome) {
        return new Cat(nome);
    }
    public static Optional<Cat> getCat(String nome) {
        return Optional.empty();
    }
}