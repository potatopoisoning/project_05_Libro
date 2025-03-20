package pj.spring.vo;

public class DeliveryInfoVO {
    private String address;         // ����� �ּ�
    private String detailAddress;   // �� �ּ�
    private String extraAddress;    // �߰� �ּ� ���� (��: ���� �׸�)
    private String memo;            // ��� �޸�

    // �⺻ ������
    public DeliveryInfoVO() {}

    // ������
    public DeliveryInfoVO(String address, String detailAddress, String extraAddress, String memo) {
        this.address = address;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
        this.memo = memo;
    }

    // Getter & Setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getExtraAddress() {
        return extraAddress;
    }

    public void setExtraAddress(String extraAddress) {
        this.extraAddress = extraAddress;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "DeliveryInfoVO{" +
               "address='" + address + '\'' +
               ", detailAddress='" + detailAddress + '\'' +
               ", extraAddress='" + extraAddress + '\'' +
               ", memo='" + memo + '\'' +
               '}';
    }
}

