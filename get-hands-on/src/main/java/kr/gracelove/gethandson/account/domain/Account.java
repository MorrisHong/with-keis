package kr.gracelove.gethandson.account.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
	private AccountId id;
	private Money baselineBalance;
	private ActivityWindow activityWindow;

	public static Account withoutId(Money baselineBalance, ActivityWindow activityWindow) {
		return new Account(null, baselineBalance, activityWindow);
	}

	public static Account withId(AccountId accountId, Money baselineBalance, ActivityWindow activityWindow) {
		return new Account(accountId, baselineBalance, activityWindow);
	}

	public Money calculateBalance() {
		return Money.add(this.baselineBalance, this.activityWindow.calculateBalance(this.id));
	}

	public boolean withdraw(Moeny moeny, AccountId targetAccountId) {
		if (!mayWithdraw(moeny)) {
			return false;
		}

		Activity withdraw = new Activity(
				this.id,
				this.id,
				targetAccountId,
				LocalDateTime.now(),
				moeny
		);

		this.activityWindow.addActivity(withdraw);

		return true;
	}

	private boolean mayWithdraw(Money money) {
		return Money.add(
				this.calculateBalance(),
				money.negate()
		).isPositive();
	}

	public boolean deposit(Money money, AccountId sourceAccountId) {
		Activity deposit = new Activity(
				this.id,
				sourceAccountId,
				this.id,
				LocalDateTime.now(),
				money
		);

		this.activityWindow.addActivity(deposit);
		return true;
	}


}
