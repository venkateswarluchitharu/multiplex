package com.multiplex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "MULTIPLEX_DTLS")
public class MultiplexEntity {
	
	@Id
	@SequenceGenerator(name = "mid_seq_gen", sequenceName = "MOVIE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "mid_seq_gen", strategy = GenerationType.SEQUENCE)
	private Long multiplex_id;
	
	private String multiplex_name;
	private String multiplex_address;
	private String multiplex_rating;

}
