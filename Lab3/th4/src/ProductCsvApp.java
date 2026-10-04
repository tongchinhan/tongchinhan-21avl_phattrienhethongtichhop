package th4.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductCsvApp {
    public static void main(String[] args) {
       Path input = Path.of("th4", "data", "products.csv");
Path report = Path.of("th4", "data", "report.txt");

        List<Product> products = new ArrayList<>();
        
        try {
            // Tự động đảm bảo thư mục data tồn tại
            Files.createDirectories(input.getParent());

            // Đọc tệp CSV
            try (BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8)) {
                String header = reader.readLine(); // bỏ qua dòng tiêu đề
                if (header == null) {
                    System.err.println("Tệp CSV trống.");
                    return;
                }
                
                String line;
                int lineNumber = 1;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.isBlank()) continue;
                    
                    String[] parts = line.split(",", -1);
                    if (parts.length != 4) {
                        System.err.println("Bỏ qua dòng " + lineNumber);
                        continue;
                    }
                    try {
                        products.add(new Product(
                                parts[0].trim(),
                                parts[1].trim(),
                                Double.parseDouble(parts[2].trim()),
                                Integer.parseInt(parts[3].trim())
                        ));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Dòng " + lineNumber + " không hợp lệ: " + e.getMessage());
                    }
                }
            }

            // Tính tổng và hiển thị danh sách sản phẩm
            double total = 0;
            for (Product product : products) {
                System.out.println(product);
                total += product.inventoryValue();
            }

            // Ghi báo cáo vào tệp report.txt
            try (BufferedWriter writer = Files.newBufferedWriter(report, StandardCharsets.UTF_8)) {
                writer.write("Số sản phẩm: " + products.size());
                writer.newLine();
                writer.write("Tổng giá trị tồn kho: %,.0f VND".formatted(total));
                writer.newLine();
            }
            
            System.out.println("Đã ghi báo cáo thành công vào " + report.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Lỗi xử lý tệp: " + e.getMessage());
        }
    }
}