package cn.xa.eyre.outpadm.domain;

public class ClinicIndex {
    private String clinicLabel;

    private String clinicDept;

    private String doctor;

    private String doctorTitle;

    private String clinicType;

    private String inputCode;

    private String clinicPosition;

    private String clinicIndex;

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public String getClinicDept() {
        return clinicDept;
    }

    public void setClinicDept(String clinicDept) {
        this.clinicDept = clinicDept == null ? null : clinicDept.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle == null ? null : doctorTitle.trim();
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getClinicPosition() {
        return clinicPosition;
    }

    public void setClinicPosition(String clinicPosition) {
        this.clinicPosition = clinicPosition == null ? null : clinicPosition.trim();
    }

    public String getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(String clinicIndex) {
        this.clinicIndex = clinicIndex == null ? null : clinicIndex.trim();
    }
}