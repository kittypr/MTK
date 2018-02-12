import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public static void main(String[] args) {
        try (InputStreamReader in = new InputStreamReader(System.in)) {
            Parser parser = new Parser(new Lexer(in));
            System.out.println("Expression result: " + parser.calculate());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
