package id.co.pyquick01;

public class CodeModel {
    private String jenisCode;
    private String detailCode;

    public CodeModel(String jenisCode, String detailCode) {
        this.jenisCode = jenisCode;
        this.detailCode = detailCode;
    }

    public String getJenisCode() {
        return jenisCode;
    }

    public String getDetailCode() {
        return detailCode;
    }
}
