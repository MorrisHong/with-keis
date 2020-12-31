package kr.gracelove.gethandson.account.adapter.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/30
 */

@Entity
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class AccountJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
