package pj.spring.vo;

public class AttachmentVO extends AttachmentDetailVO {
	private String attachment_no;			// ÷�����Ϲ�ȣ
	private String attachment_type;			// ÷�����ϱ���
	private String attachment_notice_no;	// �������� ��ȣ
	private String attachment_contact_no;	// ���� ��ȣ
	private String attachment_review_no;	// ���� ��ȣ
	private String attachment_product_no; 	// ��ǰ ��ȣ
	
	public String getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(String attachment_no) {
		this.attachment_no = attachment_no;
	}
	public String getAttachment_type() {
		return attachment_type;
	}
	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
	}
	public String getAttachment_notice_no() {
		return attachment_notice_no;
	}
	public void setAttachment_notice_no(String attachment_notice_no) {
		this.attachment_notice_no = attachment_notice_no;
	}
	public String getAttachment_contact_no() {
		return attachment_contact_no;
	}
	public void setAttachment_contact_no(String attachment_contact_no) {
		this.attachment_contact_no = attachment_contact_no;
	}
	public String getAttachment_review_no() {
		return attachment_review_no;
	}
	public void setAttachment_review_no(String attachment_review_no) {
		this.attachment_review_no = attachment_review_no;
	}
	
	
}
