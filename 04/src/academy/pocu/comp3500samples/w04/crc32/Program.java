package academy.pocu.comp3500samples.w04.crc32;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class Program {
    public static void main(String[] args) {
        {
            String input1 = "My text";
            String input2 = "My text";
            String input3 = "My different text";

            byte[] input1Bytes = input1.getBytes();
            byte[] input2Bytes = input2.getBytes();
            byte[] input3Bytes = input3.getBytes();

            Checksum crc32 = new CRC32();

            crc32.update(input1Bytes, 0, input1Bytes.length);
            long checksum1 = crc32.getValue();

            crc32.reset();

            crc32.update(input2Bytes, 0, input2Bytes.length);
            long checksum2 = crc32.getValue();

            crc32.reset();

            crc32.update(input3Bytes, 0, input3Bytes.length);
            long checksum3 = crc32.getValue();

            System.out.println("Checksums for:");
            System.out.println(String.format("1. input1: %d", checksum1));
            System.out.println(String.format("2. input2: %d", checksum2));
            System.out.println(String.format("3. input3: %d", checksum3));
        }

        {
            String input = "My long long text";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

            CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
            byte[] buffer = new byte[1024];

            try {
                while (checkedInputStream.read(buffer, 0, buffer.length) >= 0) {
                    // intentionally empty
                }

                long checksum = checkedInputStream.getChecksum().getValue();

                System.out.println(String.format("input: %d", checksum));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
