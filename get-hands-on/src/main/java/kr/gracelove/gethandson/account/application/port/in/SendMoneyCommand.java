package kr.gracelove.gethandson.account.application.port.in;

import kr.gracelove.gethandson.account.shared.SelfValidation;

import javax.validation.constraints.NotNull;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/28
 */

public class SendMoneyCommand extends SelfValidation<SendMoneyCommand> {

	@NotNull
	private final AccountId sourceAccountId;
	@NotNull
	private final AccountId targetAccountId;
	@NotNull
	private final Money money;

	public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.money = money;
	}
}
