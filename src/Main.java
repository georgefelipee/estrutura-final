public class Main {
    public static void main(String[] args) {
        String input = "ea";

        // Calcular as frequências dos caracteres dinamicamente
        FrequencyCounter counter = new FrequencyCounter(input.length());
        for (char c : input.toCharArray()) {
            counter.add(c);
        }

        char[] characters = counter.getCharacters();
        int[] frequencies = counter.getFrequencies();

        HuffmanTree tree = new HuffmanTree();
        Node root = tree.buildTree(characters, frequencies);

        HuffmanCoding coding = new HuffmanCoding();
        CodeMap codeMap = coding.getCodes(root, characters.length);

        Compressor compressor = new Compressor();
        String compressed = compressor.compress(input, codeMap);

        Decompressor decompressor = new Decompressor();
        String decompressed = decompressor.decompress(compressed, root);

        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
