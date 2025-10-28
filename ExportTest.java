interface DataExporter {
    void exportToCSV();
    void exportToPDF();

    default void exportToJSON() {
        System.out.println("JSON export not supported by this module.");
    }
}

class ReportExporter implements DataExporter {
    public void exportToCSV() {
        System.out.println("Exporting report as CSV...");
    }

    public void exportToPDF() {
        System.out.println("Exporting report as PDF...");
    }

    public void exportToJSON() {
        System.out.println("Exporting report as JSON...");
    }
}

class SummaryExporter implements DataExporter {
    public void exportToCSV() {
        System.out.println("Exporting summary as CSV...");
    }

    public void exportToPDF() {
        System.out.println("Exporting summary as PDF...");
    }
}

public class ExportTest {
    public static void main(String[] args) {
        DataExporter r = new ReportExporter();
        DataExporter s = new SummaryExporter();

        r.exportToCSV();
        r.exportToJSON();

        s.exportToCSV();
        s.exportToJSON();
    }
}
