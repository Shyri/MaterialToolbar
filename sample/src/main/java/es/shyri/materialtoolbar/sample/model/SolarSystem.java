package es.shyri.materialtoolbar.sample.model;

import android.content.Context;

import java.util.ArrayList;

import es.shyri.materialtoolbar.sample.R;

/**
 * Created by shyri on 10/10/15.
 */
public class SolarSystem {
    Context context;

    public SolarSystem (Context context) {
        this.context = context;
    }

    private CelestialBody buildMercury() {
        CelestialBody mercury = new CelestialBody(
                context.getString(R.string.name_mercury),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_mercury),
                R.drawable.mercury);

        return mercury;
    }

    private CelestialBody buildVenus() {
        CelestialBody venus =  new CelestialBody(
                context.getString(R.string.name_venus),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_venus),
                R.drawable.venus);
        venus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_2002_VE68),
                CelestialBody.CATEGORY.ASTEROID,
                context.getString(R.string.description_2002_VE68),
                R.drawable.vesixeight));
        venus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_4183_Cuno),
                CelestialBody.CATEGORY.ASTEROID,
                context.getString(R.string.description_4183_Cuno),
                R.drawable.cuno));

        return venus;
    }

    private CelestialBody buildEarth() {
        CelestialBody earth =  new CelestialBody(
                context.getString(R.string.name_earth),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_earth),
                R.drawable.earth);
        earth.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_3753_Cruithne),
                CelestialBody.CATEGORY.ASTEROID,
                context.getString(R.string.description_3753_Cruithne),
                R.drawable.cruithne));
        earth.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_2010_TK7),
                CelestialBody.CATEGORY.ASTEROID,
                context.getString(R.string.description_2010_TK7),
                R.drawable.tkseven));
        earth.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_moon),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_moon),
                R.drawable.moon));
        return earth;
    }

    private CelestialBody buildMars() {
        CelestialBody mars =  new CelestialBody(
                context.getString(R.string.name_mars),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_mars),
                R.drawable.mars);

        mars.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_deimos),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_deimos),
                R.drawable.deimos));

        mars.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_phobos),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_phobos),
                R.drawable.phobos));
        return mars;
    }

    private CelestialBody buildJupiter() {
        CelestialBody jupiter = new CelestialBody(
                context.getString(R.string.name_jupiter),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_jupiter),
                R.drawable.jupiter);

        jupiter.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_io),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_io),
                R.drawable.io));

        jupiter.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_europa),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_europa),
                R.drawable.europa));

        jupiter.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_ganymede),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_ganymed),
                R.drawable.genymede));

        jupiter.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_callisto),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_callisto),
                R.drawable.callisto));

        return jupiter;
    }

    private CelestialBody buildSaturn() {
        CelestialBody saturn = new CelestialBody(
                context.getString(R.string.name_saturn),
                null,
                context.getString(R.string.description_saturn),
                R.drawable.saturn);


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_mimas),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_mimas),
                R.drawable.mimas));

        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_enceladus),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_enceladus),
                R.drawable.enceladus));


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_tethys),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_tethys),
                R.drawable.tethys));


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_dione),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_dione),
                R.drawable.dione));


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_rhea),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_rhea),
                R.drawable.rhea));


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_titan),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_titan),
                R.drawable.titan));


        saturn.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_hyperion),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_hyperion),
                R.drawable.hyperion));

        return saturn;
    }

    private CelestialBody buildUranus() {
        CelestialBody uranus = new CelestialBody(
                context.getString(R.string.name_uranus),
                CelestialBody.CATEGORY.PLANET,
                context.getString(R.string.description_uranus),
                R.drawable.uranus);

        uranus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_miranda),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_miranda),
                R.drawable.miranda));

        uranus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_ariel),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_ariel),
                R.drawable.ariel));

        uranus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_umbriel),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_umbriel),
                R.drawable.umbriel));

        uranus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_titania),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_titania),
                R.drawable.titania));


        uranus.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_oberon),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_oberon),
                R.drawable.oberon));

        return uranus;
    }

    private CelestialBody buildNeptune() {
        CelestialBody neptune = new CelestialBody(
                context.getString(R.string.name_neptune),
                null,
                context.getString(R.string.description_neptune),
                R.drawable.neptune);

        neptune.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_proteus),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_proteus),
                R.drawable.proteus));

        neptune.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_triton),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_triton),
                R.drawable.triton));

        neptune.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_nereid),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_nereid),
                R.drawable.nereid));


        return neptune;
    }

    private CelestialBody buildPluto() {
        CelestialBody pluto = new CelestialBody(
                context.getString(R.string.name_pluto),
                CelestialBody.CATEGORY.DWARF_PLANET,
                context.getString(R.string.description_pluto),
                R.drawable.pluto);

        pluto.addCelestialBody(new CelestialBody(
                context.getString(R.string.name_charon),
                CelestialBody.CATEGORY.SATELLITE,
                context.getString(R.string.description_charon),
                R.drawable.charon));

        return pluto;
    }



    public CelestialBody buildSun() {
        CelestialBody sun = new CelestialBody(context.getString(R.string.name_sun),
                CelestialBody.CATEGORY.STAR,
                context.getString(R.string.description_sun),
                0);
        
        sun.addCelestialBody(buildMercury());
        sun.addCelestialBody(buildVenus());
        sun.addCelestialBody(buildEarth());
        sun.addCelestialBody(buildMars());
        sun.addCelestialBody(buildJupiter());
        sun.addCelestialBody(buildSaturn());
        sun.addCelestialBody(buildUranus());
        sun.addCelestialBody(buildNeptune());
        sun.addCelestialBody(buildPluto());

        sun.addCelestialBody(new CelestialBody(context.getString(R.string.name_ceres),
                CelestialBody.CATEGORY.DWARF_PLANET,
                context.getString(R.string.description_ceres),
                R.drawable.ceres));

        sun.addCelestialBody(new CelestialBody(context.getString(R.string.name_pallas),
                CelestialBody.CATEGORY.DWARF_PLANET,
                context.getString(R.string.description_pallas),
                R.drawable.pallas));


        sun.addCelestialBody(new CelestialBody(context.getString(R.string.name_vesta),
                CelestialBody.CATEGORY.DWARF_PLANET,
                context.getString(R.string.description_vesta),
                R.drawable.vesta));


        return sun;
    }

    public static ArrayList<CelestialBody> explode (CelestialBody celestialBody) {
        ArrayList<CelestialBody> celestialBodies = new ArrayList<>();
        if (celestialBody.getChildren() != null) {
            for (CelestialBody child : celestialBody.getChildren()) {
                celestialBodies.addAll(explode(child));
                celestialBodies.add(child);
            }
        }
        return celestialBodies;
    }
}
