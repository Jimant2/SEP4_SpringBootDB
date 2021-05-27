package WebAPI.Terrarium;

import java.io.Serializable;
import java.util.Objects;

public class TerrariumRelationshipClass implements Serializable {
    private Long terrariumId;
    private Long motherboardId;


    public TerrariumRelationshipClass() {
    }

    public TerrariumRelationshipClass(Long terrariumId, Long motherboardId) {
        this.terrariumId = terrariumId;
        this.motherboardId = motherboardId;
    }

    public Long getTerrariumId() {
        return terrariumId;
    }

    public void setTerrariumId(Long terrariumId) {
        this.terrariumId = terrariumId;
    }

    public Long getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(Long motherboardId) {
        this.motherboardId = motherboardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerrariumRelationshipClass that = (TerrariumRelationshipClass) o;
        return terrariumId.equals(that.terrariumId) &&
                motherboardId.equals(that.motherboardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terrariumId, motherboardId);
    }
}
