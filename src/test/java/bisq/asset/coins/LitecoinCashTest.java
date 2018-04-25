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

package bisq.asset.coins;

import bisq.asset.AbstractAssetTest;

import org.junit.Test;

public class LitecoinCashTest extends AbstractAssetTest {

    public LitecoinCashTest() {
        super(new LitecoinCash());
    }

    @Test
    public void testValidAddresses() {
        assertValidAddress("CashierDaZEsyBQkuvv4c2uPZFx6m2XTgT");
        assertValidAddress("MLkLN5XA7EgfdSVTc8ER5c8vtDPoe7FYzj");
        assertValidAddress("Cff5iJo79WTvjLP4mnbSRaMivKHkAn7JkC");
    }

    @Test
    public void testInvalidAddresses() {
        assertInvalidAddress("DashierDaZEsyBQkuvv4c2uPZFx6m2XTgT");
        assertInvalidAddress("LiR9QUksM7jT61AoGBFp85oTWQScJZXzSy");
        assertInvalidAddress("Cff5iJo79WTvjLP4mnbSRaMivKHkAn7JkCC");
    }
}
