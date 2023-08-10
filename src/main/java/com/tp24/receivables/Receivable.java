package com.tp24.receivables;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Receivable")
@Table(name = "receivable",
		uniqueConstraints = {
				@UniqueConstraint(name = "receivable_reference_unique", columnNames = "reference")
		})
public class Receivable {

	@Id
	@SequenceGenerator(
			name = "receivable_sequence",
			sequenceName = "receivable_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "receivable_sequence"
	)
	@Column(
			name = "id",
			updatable = false
	)
	private Long id;
	@Column(
			name = "reference",
			nullable = false,
			unique = true
	)
	private String reference;

	@Column(
			name = "currencyCode",
			nullable = false
	)
	private String currencyCode;
	@Column(
			name = "issueDate",
			nullable = false
	)
	private String issueDate;

	@Column(
			name = "openingValue",
			nullable = false
	)
	private double openingValue;
	@Column(
			name = "paidValue",
			nullable = false
	)
	private double paidValue;

	@Column(
			name = "dueDate",
			nullable = false
	)
	private String dueDate;

	@Column(
			name = "closedDate"
	)
	private String closedDate;
	@Column(
			name = "cancelled",
			columnDefinition = "boolean"
	)
	private boolean cancelled;

	@Column(
			name = "debtorName",
			nullable = false
	)
	private String debtorName;

	@Column(
			name = "debtorReference",
			nullable = false
	)
	private String debtorReference;

	@Column(
			name = "debtorAddress1"
	)
	private String debtorAddress1;
	@Column(
			name = "debtorAddress2"
	)
	private String debtorAddress2;
	@Column(
			name = "debtorTown"
	)
	private String debtorTown;
	@Column(
			name = "debtorState"
	)
	private String debtorState;

	@Column(
			name = "debtorZip"
	)
	private String debtorZip;
	@Column(
			name = "debtorCountryCode",
			nullable = false
	)
	private String debtorCountryCode;

	@Column(
			name = "debtorRegistrationNumber"
	)
	private String debtorRegistrationNumber;


	public Receivable(
			String reference,
			String currencyCode,
			String issueDate,
			double openingValue,
			double paidValue,
			String dueDate,
			String closedDate,
			boolean cancelled,
			String debtorName,
			String debtorReference,
			String debtorAddress1,
			String debtorAddress2,
			String debtorTown,
			String debtorState,
			String debtorZip,
			String debtorCountryCode,
			String debtorRegistrationNumber) {
		this.reference = reference;
		this.currencyCode = currencyCode;
		this.issueDate = issueDate;
		this.openingValue = openingValue;
		this.paidValue = paidValue;
		this.dueDate = dueDate;
		this.closedDate = closedDate;
		this.cancelled = cancelled;
		this.debtorName = debtorName;
		this.debtorReference = debtorReference;
		this.debtorAddress1 = debtorAddress1;
		this.debtorAddress2 = debtorAddress2;
		this.debtorTown = debtorTown;
		this.debtorState = debtorState;
		this.debtorZip = debtorZip;
		this.debtorCountryCode = debtorCountryCode;
		this.debtorRegistrationNumber = debtorRegistrationNumber;
	}

	public Receivable() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public double getOpeningValue() {
		return openingValue;
	}

	public void setOpeningValue(double openingValue) {
		this.openingValue = openingValue;
	}

	public double getPaidValue() {
		return paidValue;
	}

	public void setPaidValue(double paidValue) {
		this.paidValue = paidValue;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public String getDebtorName() {
		return debtorName;
	}

	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}

	public String getDebtorReference() {
		return debtorReference;
	}

	public void setDebtorReference(String debtorReference) {
		this.debtorReference = debtorReference;
	}

	public String getDebtorAddress1() {
		return debtorAddress1;
	}

	public void setDebtorAddress1(String debtorAddress1) {
		this.debtorAddress1 = debtorAddress1;
	}

	public String getDebtorAddress2() {
		return debtorAddress2;
	}

	public void setDebtorAddress2(String debtorAddress2) {
		this.debtorAddress2 = debtorAddress2;
	}

	public String getDebtorTown() {
		return debtorTown;
	}

	public void setDebtorTown(String debtorTown) {
		this.debtorTown = debtorTown;
	}

	public String getDebtorState() {
		return debtorState;
	}

	public void setDebtorState(String debtorState) {
		this.debtorState = debtorState;
	}

	public String getDebtorZip() {
		return debtorZip;
	}

	public void setDebtorZip(String debtorZip) {
		this.debtorZip = debtorZip;
	}

	public String getDebtorCountryCode() {
		return debtorCountryCode;
	}

	public void setDebtorCountryCode(String debtorCountryCode) {
		this.debtorCountryCode = debtorCountryCode;
	}

	public String getDebtorRegistrationNumber() {
		return debtorRegistrationNumber;
	}

	public void setDebtorRegistrationNumber(String debtorRegistrationNumber) {
		this.debtorRegistrationNumber = debtorRegistrationNumber;
	}

	@Override
	public String toString() {
		return "Receivable{" +
				"id=" + id +
				", reference='" + reference + '\'' +
				", currencyCode='" + currencyCode + '\'' +
				", issueDate='" + issueDate + '\'' +
				", openingValue=" + openingValue +
				", paidValue=" + paidValue +
				", dueDate='" + dueDate + '\'' +
				", closedDate='" + closedDate + '\'' +
				", cancelled=" + cancelled +
				", debtorName='" + debtorName + '\'' +
				", debtorReference='" + debtorReference + '\'' +
				", debtorAddress1='" + debtorAddress1 + '\'' +
				", debtorAddress2='" + debtorAddress2 + '\'' +
				", debtorTown='" + debtorTown + '\'' +
				", debtorState='" + debtorState + '\'' +
				", debtorZip='" + debtorZip + '\'' +
				", debtorCountryCode='" + debtorCountryCode + '\'' +
				", debtorRegistrationNumber='" + debtorRegistrationNumber + '\'' +
				'}';
	}
}
