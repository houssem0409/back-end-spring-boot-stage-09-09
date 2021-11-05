package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
	@Id
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;


}
