package muratselcuk.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers_approved")
public class EmployerApproved {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(targetEntity = Employer.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employers_id", referencedColumnName = "id", nullable = false)
	private Employer employerId;
	
	@OneToOne(targetEntity = Admin.class)
	@JoinColumn(name = "admin_id", referencedColumnName = "id")
	private Admin adminId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
}
