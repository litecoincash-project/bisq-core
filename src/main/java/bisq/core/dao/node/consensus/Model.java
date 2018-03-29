/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.core.dao.node.consensus;

import bisq.core.dao.blockchain.vo.TxOutput;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;

/**
 * This model holds mutable data during parsing a tx. It is used be the various
 * controllers to store and retrieve particular state required for validation.
 */
@Getter
@Setter
class Model {
    private long availableInputValue = 0;
    @Nullable
    private TxOutput issuanceCandidate;
    @Nullable
    private TxOutput blindVoteStakeOutput;
    private boolean voteStakeSpentAtInputs;
    private boolean anyBsqOutputFound;

    // That will be set preliminary at first parsing the last output. Not guaranteed
    // that it is a valid BSQ tx at that moment.
    private byte opReturnTypeCandidate = 0x00;

    // At end of parsing when we do the full validation we set the type here
    private byte verifiedOpReturnType = 0x00;

    Model() {
    }

    Model(long availableInputValue) {
        this.availableInputValue = availableInputValue;
    }

    public void addToInputValue(long value) {
        this.availableInputValue += value;
    }

    public void subtractFromInputValue(long value) {
        this.availableInputValue -= value;
    }

    public boolean isInputValuePositive() {
        return availableInputValue > 0;
    }
}
