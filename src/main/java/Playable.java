public interface Playable {

    void play();

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }

    class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Guitar is playing");
        }
    }

    class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Piano is playing");
        }
    }
}
