package academy.pocu.comp3500samples.w04.crc32;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class Program {
    public static void main(String[] args) {
        String input1 = "My text";
        String input2 = "My text";
        String input3 = "My different text";

        byte[] input1Bytes = input1.getBytes();
        byte[] input2Bytes = input2.getBytes();
        byte[] input3Bytes = input3.getBytes();

        CRC32 crc32 = new CRC32();

        crc32.update(input1Bytes);
        long checksum1 = crc32.getValue();

        System.out.println(
                String.format("input1: %d",
                        checksum1));

        crc32.reset();

        crc32.update(input2Bytes);
        long checksum2 = crc32.getValue();

        System.out.println(
                String.format("input2: %d",
                        checksum2));

        crc32.reset();

        crc32.update(input3Bytes);
        long checksum3 = crc32.getValue();

        System.out.println(
                String.format("input3: %d",
                        checksum3));

        String input = "My long long text";
        byte[] inputArray = input.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(inputArray);

        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        byte[] buffer = new byte[1024];

        try {
            while (checkedInputStream.read(buffer,
                    0,
                    buffer.length) >= 0) {
                // intentionally empty
            }

            long checksum = checkedInputStream
                    .getChecksum()
                    .getValue();

            System.out.println(
                    String.format("input: %d",
                            checksum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
