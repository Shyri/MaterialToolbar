package es.shyri.materialtoolbar.sample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyri on 10/10/15.
 */
public class CelestialBody implements Parcelable {
    protected String name;
    protected ArrayList<CelestialBody> children;
    protected String description;
    protected int imageResourceId;
    CATEGORY category;

    public enum CATEGORY {
        STAR,
        PLANET,
        SATELLITE,
        ASTEROID,
        COMET,
        DWARF_PLANET
    }

    public CelestialBody(String name, CATEGORY category, String description, int imageResourceId) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCelestialBody(CelestialBody child) {
        if(children == null) children = new ArrayList<>();
        children.add(child);
    }

    public ArrayList<CelestialBody> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<CelestialBody> children) {
        this.children = children;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public CATEGORY getCategory() {
        return category;
    }

    public void setCategory(CATEGORY category) {
        this.category = category;
    }

    public ArrayList<CelestialBody> getCelestialBodies (String name, CelestialBody.CATEGORY category){
        ArrayList<CelestialBody> celestialBodies = new ArrayList<>();
        for(CelestialBody child : getChildren()) {

            if (name == null) {
                if (category == child.getCategory()){
                    celestialBodies.add(child);
                    continue;
                }
            }

            if(category == null) {
                if(child.getName().equals(name)) {
                    celestialBodies.add(child);
                    continue;
                }
            }

            if(child.getName().equals(name) && child.getChildren() != null) {
                for(CelestialBody child2 : child.getChildren()){
                    if(category == child2.getCategory()) {
                        celestialBodies.add(child2);
                    }
                }
                continue;
            }
        }
        return celestialBodies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeList(this.children);
        dest.writeString(this.description);
        dest.writeInt(this.imageResourceId);
        dest.writeInt(this.category == null ? -1 : this.category.ordinal());
    }

    protected CelestialBody(Parcel in) {
        this.name = in.readString();
        this.children = new ArrayList<CelestialBody>();
        in.readList(this.children, List.class.getClassLoader());
        this.description = in.readString();
        this.imageResourceId = in.readInt();
        int tmpCategory = in.readInt();
        this.category = tmpCategory == -1 ? null : CATEGORY.values()[tmpCategory];
    }

    public static final Parcelable.Creator<CelestialBody> CREATOR = new Parcelable.Creator<CelestialBody>() {
        public CelestialBody createFromParcel(Parcel source) {
            return new CelestialBody(source);
        }

        public CelestialBody[] newArray(int size) {
            return new CelestialBody[size];
        }
    };
}
