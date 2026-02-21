# Particle Link 
A Java Swing project that simulates a dynamic particle field where particles move, bounce off walls, and connect with nearby particles using color-blended lines. Inspired by [Diogo Correia's website's background](https://diogotc.com);

This project was built as a practice exercise to explore: 
* OOP in Java
* Swing graphics and rendering
* Animation using javax.swing.Timer
* Color manipulation using HSB (Hue, Saturation, Brightness)


## Overview
* 100 animated particles
* Directional movement using trigonometry
* Border collision detection with color changes
* Dynamic line connections betweens nearby particles


## Preview

![Particle Link](https://github.com/user-attachments/assets/774621ac-9154-4c4b-aeac-043c2c122c1b)


## How It Works

Each `Particle` object contains:
* `x`, `y` - Position
* `r` - Radius
* `dir` - Direction (degrees)
* `hue` - Color value (HSB)

Movement is calculated using basic trigonometry.
```java
double rad = Math.toRadians(dir);
x += Math.sin(rad) * step;
y -= Math.cos(rad) * step;
```

How the blending works:
1. Calculate the difference between two hues.

$\Delta h_{\text{raw}} = h_2 - h_1$

```java
float dif = hue2 - hue;
```
2. Finding the shortest path around the colour wheel to ensure proper colour blending.

$\Delta h_{\text{circle}} = \left( (\Delta h_{\text{raw}} + 180^\circ) \bmod 360^\circ \right) - 180^\circ$

```java
dif = ((dif + 180f) % 360f);
if (dif < 0) dif += 360f;
dif -= 180f;
```
3. Mixing the hues by moving halfway toward the second particle's hue.

$h_{\text{mix}} = (h_1 + \frac{\Delta h_{\text{circle}}}{2}) \bmod 360^\circ$

```java
float mixedHue = (hue + dif / 2f + 360f) % 360f;
```
